package com.mypro.ssm.controller;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/applicationContext-*"})
public class BaseMapperTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void interupt() {
        throw new RuntimeException();
    }

    /**
     * 初始化表
     *
     * @throws Exception
     */
    @Test
    public void initTables() throws Exception {
        String[] sqls = getSqls("table.sql");
        String[] sqls2 = getSqls("data.sql");
        Operation operation = Operations.sequenceOf(
                Operations.sql(sqls),
                Operations.sql(sqls2)
        );
        DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), operation);
        dbSetup.launch();
    }

    private String[] getSqls(String filename) throws IOException {
        URL url = BaseMapperTest.class.getClassLoader().getResource(filename);
        if (url == null) {
            throw new RuntimeException("找不到data.sql文件");
        }
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(url.getPath()), "utf-8");
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }

        // 删除/* */注释
        String s = deletePattern(sb.toString(), "\\/\\*[\\s\\S]*?\\*\\/");
        // 删除--注释
        String s2 = deletePattern2(s);
        return s2.split(";");

    }

    private String deletePattern2(String str) {
        Pattern p = Pattern.compile("^-- ");
        String[] split = str.split("\n");
        StringBuffer sb = new StringBuffer();
        for (String s : split) {
            Matcher m = p.matcher(s);
            if (!m.find()) {
                sb.append(s).append("\n");
            }
        }
        int i = sb.lastIndexOf("\n");
        StringBuffer newsb = sb.delete(i, i + 1);
        return newsb.toString();
    }

    private String deletePattern(String sb, String... patterns) {
        String result = sb;
        for (String pattern : patterns) {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(result);
            result = m.replaceAll("");
        }
        return result;
    }
}

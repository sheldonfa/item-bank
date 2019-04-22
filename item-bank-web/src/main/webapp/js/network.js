(function (w) {
        w.network = {
            listQuestion: function (categoryId) {
                var df = $.Deferred();
                $.ajax({
                    type: "GET",
                    url: "/question/listbycategory?categoryId=" + categoryId + "&recursion=" + true,
                    contentType: "application/json; charset=utf-8",
                    success: function (result) {
                        df.resolve(result)
                    }
                });
                return df;

            },
            listReviewQuestion: function (categoryId) {
                var df = $.Deferred();
                $.ajax({
                    type: "GET",
                    url: "/question/listreviewbycategory?categoryId=" + categoryId,
                    contentType: "application/json; charset=utf-8",
                    success: function (result) {
                        df.resolve(result)
                    }
                });
                return df;
            },

            selectChildCategory: function (id, countType) {
                if(!countType){
                    countType=1
                }
                var df = $.Deferred();
                $.ajax({
                    type: "GET",
                    url: "/category/" + id + "/children?countType=" + countType + "&recursion=" + true,
                    contentType: "application/json; charset=utf-8",
                    success: function (result) {
                        df.resolve(result)
                    }
                });
                return df;
            },
            addQuestion: function (categoryId, content) {
                var df = $.Deferred();
                var data = {
                    categoryId: categoryId,
                    content: content
                };
                $.ajax({
                    type: "POST",
                    url: "/question",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(data),
                    success: function (result) {
                        df.resolve(result)
                    }
                });
                return df;
            },
            editQuestion: function (id, categoryId, content) {
                var df = $.Deferred();
                var data = {
                    id: id,
                    categoryId: categoryId,
                    content: content
                };
                $.ajax({
                    type: "PUT",
                    url: "/question",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(data),
                    dataType: "json",
                    success: function (result) {
                        df.resolve(result)
                    }
                });
                return df;
            },
            updatesQuestion: function (data) {
                var df = $.Deferred();
                $.ajax({
                    type: "PUT",
                    url: "/question/updates",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(data),
                    dataType: "json",
                    success: function (result) {
                        df.resolve(result)
                    }
                });
                return df;
            },
            remember: function (id, flag) {
                var df = $.Deferred();
                var data = {
                    rememberFlag: flag
                };
                $.ajax({
                    type: "PUT",
                    url: "/question/" + id + "/remember",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(data),
                    success: function (result) {
                        df.resolve(result)
                    }
                });
                return df;
            }
        }
    }
)(window);
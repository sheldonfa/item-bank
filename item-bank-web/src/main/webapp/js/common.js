function markdowntohtml() {
    var converter = new showdown.Converter()
    $(".question-md").each(function () {
        $(this).html(converter.makeHtml($.trim($(this).html())))
    });
}
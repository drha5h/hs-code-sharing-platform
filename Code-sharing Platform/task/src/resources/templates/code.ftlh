<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Code</title>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
    <div>
        <#if (code.isViewsRestricted() && code.views >= 0)><p><span id="views_restriction"><u>${code.views}</u></span> more views allowed</p></#if>
        <#if (code.isTimeRestricted() && code.time >= 0)><p>The code will be available for <span id="time_restriction"><u>${code.time}</u></span> seconds</p></#if>
        <span id="load_date">${code.date}</span>
        <pre id="code_snippet"><code>${code.code}</code></pre>
    </div>
</body>
</html>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Create</title>
</head>
<body>
    <div>
        <textarea id="code_snippet" placeholder="// write your code here"></textarea>
        <label for="time_restriction">Time restriction</label>
        <input id="time_restriction" type="text"/>
        <label for="views_restriction">Views restriction</label>
        <input id="views_restriction" type="text"/>
        <button id="send_snippet" type="submit" onclick="send()">Submit</button>

        <script>
            function send() {
                let object = {
                    "code": document.getElementById("code_snippet").value,
                    "time": document.getElementById("time_restriction").value,
                    "views": document.getElementById("views_restriction").value
                };
                let json = JSON.stringify(object);
                let xhr = new XMLHttpRequest();
                xhr.open("POST", '/api/code/new', false)
                xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
                xhr.send(json);
                if (xhr.status == 200) {
                  alert("Success!");
                }
            }
        </script>
    </div>
</body>
</html>
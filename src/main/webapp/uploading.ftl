<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <style>
        body {background-color: palegreen;}
        h1   {color: blue;
                text-align: center;

        }

        p    {color: red;}

    </style>

    <title>Wipro project</title>
    <h1>
        Wipro Project
    </h1>
    </h2>
     Made By: Saurav Roy
    </h2>
    <hr>

</head>
<body onload="updateSize();">
<form name="uploadingForm" enctype="multipart/form-data" action="/" method="POST">
    <h3>
        Upload Files to Compare:
    </h3>
    <p>
        <input id="fileInput" type="file" name="uploadingFiles" onchange="updateSize();" multiple>
        selected files: <span id="fileNum">0</span>;
        total size: <span id="fileSize">0</span>
    </p>
    <p>
        <input type="submit" value="Upload files">
    </p>
</form>
<hr>
<#--kjfd-->

<a href="http://localhost:8080/test"><button type="button">Base file</button></a>

<a href="http://localhost:8080/"><button type="button">For test</button></a>


<form name="uploadingForm" enctype="multipart/form-data" action="/test" method="POST">
    <h3>
       Upload Base File:
    </h3>
    <p>
        <input id="fileInput" type="file" name="uploadingFile" onchange="updateSize();" multiple>
        selected files: <span id="fileNum">0</span>;
        total size: <span id="fileSize">0</span>
    </p>
    <p>
        <input type="submit" value="Upload test files">
    </p>
</form>
<#--id ->link to script file and name-> link to request-->



<div>
    <div>Uploaded files:</div>
    <#list files as file>
        <div>
            ${file.getName()}
        </div>
    </#list>
</div>
<script>
    function updateSize() {
        var nBytes = 0,
            oFiles = document.getElementById("fileInput").files,
            nFiles = oFiles.length;
        for (var nFileId = 0; nFileId < nFiles; nFileId++) {
            nBytes += oFiles[nFileId].size;
        }
        var sOutput = nBytes + " bytes";
        // optional code for multiples approximation
        for (var aMultiples = ["KiB", "MiB", "GiB", "TiB", "PiB", "EiB", "ZiB", "YiB"], nMultiple = 0, nApprox = nBytes / 1024; nApprox > 1; nApprox /= 1024, nMultiple++) {
            sOutput = nApprox.toFixed(3) + " " + aMultiples[nMultiple] + " (" + nBytes + " bytes)";
        }
        // end of optional code
        document.getElementById("fileNum").innerHTML = nFiles;
        document.getElementById("fileSize").innerHTML = sOutput;
    }
</script>
</body>
</html>
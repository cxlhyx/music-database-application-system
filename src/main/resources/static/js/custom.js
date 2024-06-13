function jumpToPage() {
    var selectedTable = document.getElementById("tables").value;
    switch(selectedTable) {
        case "album":
            window.location.href = "/album/index";
            break;
        case "band":
            window.location.href = "/band/index";
            break;
        case "bandmember":
            window.location.href = "/bandmember/index";
            break;
        case "company":
            window.location.href = "/company/index";
            break;
        case "composer":
            window.location.href = "/composer/index";
            break;
        case "lyricist":
            window.location.href = "/lyricist/index";
            break;
        case "performer":
            window.location.href = "/performer/index";
            break;
        case "singer":
            window.location.href = "/singer/index";
            break;
        case "singsong":
            window.location.href = "/singsong/index";
            break;
        case "song":
            window.location.href = "/song/index";
            break;
        default:
            window.location.href = "/error";
    }
}
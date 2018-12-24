$(function () {
    $("#submitAnnouncement").click(function () {
        if (parseInt($("input[type='file']").get(0).files.length) > 5){
            alert("You can only upload a maximum of 5 images.");
            return false;
        }
    })
});
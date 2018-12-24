function deleteAnnouncement(id, img) {
    $.ajax({
        type: "POST",
        url: "processDelete",
        data: {id: id}
    });

    $(img).closest('div.card').remove();
}
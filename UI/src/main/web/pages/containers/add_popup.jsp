<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="${pageContext.request.contextPath}/js/modal.js"></script>
<script src="${pageContext.request.contextPath}/js/image_upload_validation.js"></script>
<div class="modal fade" id="announcementModal" tabindex="-1" role="dialog" aria-labelledby="modalTitle"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalTitle">Add Announcement</h5>
            </div>
            <form:form id="popupForm" cssClass="col-sm-12" modelAttribute="newAnnouncement" action="processAdd"
                      enctype="multipart/form-data" method="post">
            <div class="modal-body">
                <div class="form-group">
                    <label for="newTitle">Title</label>
                    <form:input id="newTitle" class="form-control form-search-control" path="title"
                                placeHolder="Title" required="true"/>
                </div>
                <div class="form-group">
                    <label for id="description">Description</label>
                    <form:textarea id="newDescription" class="form-control form-search-control" path="description"
                                   placeHolder="Enter Description" required="true"/>
                </div>
                <div class="form-group">
                    <label for="newBrand">Brand</label>
                    <form:input id="newBrand" class="form-control form-search-control" path="brand" placeHolder="Brand"
                                name="brand" required="true"/>
                </div>
                <div class="form-group">
                    <label for="newModel">Model</label>
                    <form:input id="newModel" class="form-control form-search-control" path="model" placeHolder="Model"
                                name="model" required="true"/>
                </div>
                <div class="form-group">
                    <label for="newPrice">Price</label>
                    <form:input id="newPrice" class="form-control form-search-control" path="price" placeHolder="Price"
                                name="price" required="true"/>
                </div>
                <div class="form-group">
                    <label for="newFabricationDate">FabricationDate</label>
                    <form:input id="newFabricationDate" class="form-control form-search-control"
                                path="fabricationDate"
                                placeHolder="Date" name="fabricationDate" required="true"/>
                </div>
                <div class="modal-footer">
                    <input class="form-control-file" accept="image/jpeg,image/png" type="file" name="uploadedImages"
                           multiple/>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button id="submitAnnouncement" type="submit" class="btn btn-primary">Create</button>
                </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
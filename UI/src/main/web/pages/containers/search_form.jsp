<!DOCTYPE html>
<div class="search-container">
    <form:form id="searchForm" cssClass="col-sm-12" modelAttribute="searchAnnouncement" action="processSearch"
               method="post">
    <div class="form-group row"></div>
    <div class="form-group row">
        <label for="brand" class="col-sm-1 col-form-label">Brand</label>
        <div class="col-sm-3">
            <form:input id="brand" class="form-control form-search-control" path="brand" placeHolder="Brand"
                        name="brand"/>
        </div>
        <label for="model" class="col-sm-2.5 col-form-label">Model</label>
        <div class="col-sm-3">
            <form:input id="model" class="form-control form-search-control" path="model" placeHolder="Model"
                        name="model"/>
        </div>
    </div>
    <div class="form-group row">
        <label for="price" class="col-sm-1 col-form-label">Price</label>
        <div class="col-sm-3">
            <form:input id="price" class="form-control form-search-control" path="price" placeHolder="Max Price"
                        name="price"/>
        </div>
        <label for="fabricationDate" class="col-sm-2.5 col-form-label">Fabrication Date</label>
        <div class="col-sm-5">
            <form:input id="fabricationDate" class="form-control form-search-control" path="fabricationDate"
                        placeHolder="Date" name="fabricationDate"/>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <c:choose>
                <c:when test="${user.logged == true}">
                    <button type="button" id="addAnnouncement" class="btn btn-success" data-toggle="modal" data-target="#announcementModal">
                        <jsp:text>Add New Announcement</jsp:text>
                    </button>
                </c:when>
            </c:choose>
        </div>
        <div class="col-sm-3">
            <button type="submit" class="btn btn-primary btn-block search-btn">
                <jsp:text>Search</jsp:text>
                <img class="search-img" src="${pageContext.request.contextPath}/images/search_icon.png"/>
            </button>
        </div>
        </form:form>
        <%@include file="add_popup.jsp" %>
    </div>
</div>
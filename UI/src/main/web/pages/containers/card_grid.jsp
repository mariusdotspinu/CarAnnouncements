<!DOCTYPE html>
<script src="${pageContext.request.contextPath}/js/submit_delete.js"></script>
<div class="container mt-3 card-container">
    <div class="row align-items-center">
        <div class="card-deck">
            <c:forEach var="announcementEntry" items="${announcements}">
                <div class="card mb-4" style="min-width: 18rem; max-width: 18rem;">
                    <c:choose>
                        <c:when test="${user.logged == true}">
                            <div class="float-right" style="margin:10px">
                                <img src="${pageContext.request.contextPath}/images/delete_card_icon.png"
                                     onclick="deleteAnnouncement(${announcementEntry.id}, this)"
                                     onmouseover="this.src='${pageContext.request.contextPath}/images/delete_card_icon_hover.png';"
                                     onmouseout="this.src='${pageContext.request.contextPath}/images/delete_card_icon.png'"/>
                            </div>
                        </c:when>
                    </c:choose>

                    <c:if test="${announcementEntry.images.size() ne 0}">
                        <img class="card-img-top" src="data:image/jpeg;base64,${announcementEntry.images.get(0)}"
                             alt="Car Image">
                    </c:if>
                    <a href="${pageContext.request.contextPath}/details/${announcementEntry.id}">
                        <div class="card-body">
                            <h5 class="card-title title"><c:out value="${announcementEntry.title}"/></h5>
                            <p class="card-text text-truncate"><c:out value="${announcementEntry.description}"/></p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item brand">Brand: <c:out value="${announcementEntry.brand}"/></li>
                            <li class="list-group-item model">Model: <c:out value="${announcementEntry.model}"/></li>
                            <li class="list-group-item price">Price: <c:out value="${announcementEntry.price}"/></li>
                        </ul>
                    </a>
                </div>

            </c:forEach>
        </div>
    </div>
</div>
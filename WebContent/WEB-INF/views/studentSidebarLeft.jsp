<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul>
<c:forEach var="menuList" items="${userDetails.userLinks}">
<li style="margin-bottom: 8px;"><a href="${menuList.linkAction}">${menuList.linkName}</a></li>
</c:forEach> 
</ul>

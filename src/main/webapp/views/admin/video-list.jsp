<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<a href="<c:url value="/admin/video/add"/>">Add Video</a>
<br>
<hr>

<table border="1" width="100%">
    <tr>
        <th>STT</th>
        <th>Video ID</th>
        <th>Poster</th>
        <th>Video Title</th>
    
        <th>Action</th>
    </tr>
    <c:forEach items="${listcate}" var="cate" varStatus="STT">
        <tr>
            <td>${STT.index + 1}</td>
            <td>${cate.videoId }</td>
            
			<td>
            <c:if test="${cate.poster.substring(0,5) == 'https'}">
                <c:url value="${cate.poster}" var="imgUrl"></c:url>
            </c:if>
            <c:if test="${cate.poster.substring(0, 5) != 'https'}">
                <c:url value="/image?fname=${cate.poster}" var="imgUrl"></c:url>
            </c:if>
            
            <img height="150" width="200" src="${imgUrl}" />
            
            </td>
            
            <td>${cate.title}</td>
       
            <td>
                <a href="<c:url value='/admin/video/edit?id=${cate.videoId}'/>">Sửa</a> | 
                <a href="<c:url value='/admin/video/delete?id=${cate.videoId}'/>">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>

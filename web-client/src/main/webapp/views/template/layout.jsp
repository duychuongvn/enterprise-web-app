<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<body>
<table width="100%">
    <tr>
        <td colspan="2"><tiles:insertAttribute name="header"/></td>
    </tr>
    <tr>
        <td width="80%"><tiles:insertAttribute name="body"/></td>
    </tr>
    <tr>
        <td colspan="2"><tiles:insertAttribute name="footer"/></td>
    </tr>
</table>
</body>
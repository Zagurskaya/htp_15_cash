<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="/include/head.jsp" %>
<body>
<div class="container">
    <%@ include file="/include/menucashnew.jsp" %>
    <br>
    <H4><fmt:message key="page.payment1100.title"/></H4>
    <%@ include file="/include/infomessage.jsp" %>
    <form class="form-horizontal" actionType="do?command=Payment1100" method="post">
        <fieldset>
            <div class="row">
                <div class=col-md-2><fmt:message key="page.payment1100.label.cod"/></div>
                <div class=col-md-3><fmt:message key="page.payment1100.label.name"/></div>
                <div class=col-md-2><fmt:message key="page.payment1100.label.sum"/>*</div>
            </div>
            <c:forEach items="${currencies}" var="currency">
                <div class="row">
                    <div class="col-md-2">
                        <input id="id" name="id" type="text" readonly placeholder="" class="form-control input-md"
                               required="" value="${currency.id}">
                    </div>

                    <div class="col-md-3">
                        <input id="name" name="name" type="text" readonly placeholder="" class="form-control input-md"
                               required=""
                        <c:if test="${cookie.local.value==null || cookie.local.value=='ru'}">
                               value="${currency.nameRU}"
                        </c:if>
                        <c:if test="${cookie.local.value=='en'}">
                               value="${currency.nameEN}"
                        </c:if>
                        >
                    </div>

                    <div class="col-md-2">
                        <input id="sum" name="sum" type="text" placeholder="" class="form-control input-md" value="">
                    </div>

                </div>
            </c:forEach>
            <br>
            <p><fmt:message key="page.payment1100.label.description"/>*</p>
            <div class="col-md-7">
                <input id="specification" name="specification" type="text" placeholder="" class="form-control input-md"
                       required pattern="[a-zA-Zа-яА-Я0-9\s_-]{1,}"
                       value="сдано денежных средств по расходному кассовому ордеру">
            </div>
            <br>
            <br>
            <div class="form-group">
                <div class="col-md-8">
                    <button id="enter" name="enter" class="btn btn-primary">
                        <fmt:message key="page.payment1100.button.enter"/></button>
                    <button id="balance" name="balance" class="btn btn-primary">
                        <fmt:message key="page.payment1100.button.balance"/></button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>

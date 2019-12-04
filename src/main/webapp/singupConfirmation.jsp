<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <c:import url="head.jsp"/>
    <body>
        <div class="container">
            <div class="row">
                <c:import url="header.jsp"/>
            </div>
            <div class="row">
                <c:import url="navbar.jsp"/>
            </div>
            <div class="row">
                <div class="col-12 mx-auto mb-3">
                    <div class="card border-info">
                        <div class="card-header bg-info">
                            <h4 class="text-white font-italic font-weight-bold">Confirmation</h4>
                        </div>
                        <div class="card-body">
                         <p class="mx-auto">Successfully added new user.</p>
                        </div>
                    </div>
                </div>
            </div>
            <footer class="row">
                <c:import url="footer.jsp"/>
            </footer>
        </div>
    </body>
</html>

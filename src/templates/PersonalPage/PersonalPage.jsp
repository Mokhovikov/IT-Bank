<%@ page import="com.example.demo.Models.Member" %>
<%@ page import="org.springframework.web.bind.annotation.RequestParam" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en" xmlns:th="http://www.w3.org/1999/html">

<head>
    <meta charset="UTF-8">
    <title>My Account</title>
</head>
<body>
<link th:href="@{../../PersonalPage/PersonalPageStyle.css}" rel="stylesheet">
<link th:href="@{../../OthersThingsCSS/CreditCard.css}" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link th:href="@{../../PersonalPage/MenuButton.css}" rel="stylesheet">


</body>

<div class="container">
    <div class="container-elem">

        <div class="menu-wrap">
            <div class="header-name">
                IT BANK
            </div>
            <input type="checkbox" class="toggler">
            <div class="hamburger"><div></div></div>
            <div class="menu">
                <div>
                    <div>
                        <ul class="overlay-link">
                            <li><a href="/PersonalAccount/MyWallet">My wallet</a></li>
                            <li><a href="#">Payments</a></li>
                            <li><a href="#">Services</a></li>
                            <li><a href="#">Others</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>




        <img
                th:src="@{../../playground_assets/Header-yellow.png}"
                class="header-yellow"
                alt=""
        />

        <img
                th:src="@{../../playground_assets/right-top-form.png}"
                class="top-right-container"
                alt=""
        />

        <div class="account-text">
            Personal
            Account
        </div>
        <button class="collapsible">

            <img
                    th:src="@{../../playground_assets/SignIn.png}"

                    class="picture"
            />
        </button>
        <div class="content">
            <ul >
                <li><a href="/PersonalAccount/MyWallet">My wallet</a></li>
                <li><a href="#">Settings</a></li>
                <li><a th:href="@{/home}">Logout</a></li>
            </ul>



        </div>


        <div class="greetings-client">
            Welcome back!
            <%
                HttpServletRequest request1;
                String name = request1.getParameter("first_name");
                String lastname = request1.getParameter("last_name");

            %>

            <%=name%> <%=lastname%>

        </div>



        <div class="card">
            <div class="card__info">
                <div class="card__logo">IT Bank</div>
                <div class="card__chip">
                    <svg class="card__chip-lines" role="img" width="20px" height="20px" viewBox="0 0 100 100" aria-label="Chip">
                        <g opacity="0.8">
                            <polyline points="0,50 35,50" fill="none" stroke="#000" stroke-width="2" />
                            <polyline points="0,20 20,20 35,35" fill="none" stroke="#000" stroke-width="2" />
                            <polyline points="50,0 50,35" fill="none" stroke="#000" stroke-width="2" />
                            <polyline points="65,35 80,20 100,20" fill="none" stroke="#000" stroke-width="2" />
                            <polyline points="100,50 65,50" fill="none" stroke="#000" stroke-width="2" />
                            <polyline points="35,35 65,35 65,65 35,65 35,35" fill="none" stroke="#000" stroke-width="2" />
                            <polyline points="0,80 20,80 35,65" fill="none" stroke="#000" stroke-width="2" />
                            <polyline points="50,100 50,65" fill="none" stroke="#000" stroke-width="2" />
                            <polyline points="65,65 80,80 100,80" fill="none" stroke="#000" stroke-width="2" />
                        </g>
                    </svg>
                    <div class="card__chip-texture"></div>
                </div>
                <div class="card__type">debit</div>
                <div class="card__number">
                    <span class="card__digit-group">0000</span>
                    <span class="card__digit-group">0021</span>
                    <span class="card__digit-group">4748</span>
                    <span class="card__digit-group">3647</span>
                </div>
                <div class="card__valid-thru" aria-label="Valid thru">Valid<br>thru</div>
                <div class="card__exp-date"><time datetime="2038-01">04/27</time></div>
                <div class="card__name" aria-label="Dee Stroyer">Dee Stroyer</div>
                <div class="card__vendor" role="img" aria-labelledby="card-vendor">
                    <span id="card-vendor" class="card__vendor-sr">Mastercard</span>
                </div>
            </div>
            <div class="card__texture"></div>
        </div>

        <img
                th:src="@{../../playground_assets/left-bottom-form.png}"
                class="left-bottom-form"
                alt=""
        />
    </div>
</div>
<script type="text/javascript" th:src="@{../../assets/AdditionWithJS/SignInForm.js}"></script>
</html>
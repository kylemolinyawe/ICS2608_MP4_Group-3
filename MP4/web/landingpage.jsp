<%-- 
    Document   : landingpage
    Created on : Dec 6, 2022, 10:35:18 AM
    Author     : ralph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Presentation Page</title>
    <meta property="og:title" content="Presentation Page" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta charset="utf-8" />
    <meta property="twitter:card" content="summary_large_image" />

    <style data-tag="reset-style-sheet">
      html {  line-height: 1.15;}body {  margin: 0;}* {  box-sizing: border-box;  border-width: 0;  border-style: solid;}p,li,ul,pre,div,h1,h2,h3,h4,h5,h6,figure,blockquote,figcaption {  margin: 0;  padding: 0;}button {  background-color: transparent;}button,input,optgroup,select,textarea {  font-family: inherit;  font-size: 100%;  line-height: 1.15;  margin: 0;}button,select {  text-transform: none;}button,[type="button"],[type="reset"],[type="submit"] {  -webkit-appearance: button;}button::-moz-focus-inner,[type="button"]::-moz-focus-inner,[type="reset"]::-moz-focus-inner,[type="submit"]::-moz-focus-inner {  border-style: none;  padding: 0;}button:-moz-focus,[type="button"]:-moz-focus,[type="reset"]:-moz-focus,[type="submit"]:-moz-focus {  outline: 1px dotted ButtonText;}a {  color: inherit;  text-decoration: inherit;}input {  padding: 2px 4px;}img {  display: block;}html { scroll-behavior: smooth  }
    </style>
    <style data-tag="default-style-sheet">
      html {
        font-family: Open Sans;
        font-size: 18px;
      }

      body {
        font-weight: 400;
        font-style:normal;
        text-decoration: none;
        text-transform: none;
        letter-spacing: normal;
        line-height: 1.55;
        color: var(--dl-color-gray-black);
        background-color: var(--dl-color-gray-white);

      }
    </style>
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,600;0,700;0,800;1,300;1,400;1,600;1,700;1,800&amp;display=swap"
      data-tag="font"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&amp;display=swap"
      data-tag="font"
    />
    <style>
      html {
      scroll-behavior: smooth;
      }
    </style>
    <link rel="stylesheet" href="./css/style.css" />
  </head>
  <body>
    <div>
      <link href="./css/home.css" rel="stylesheet" />

      <div class="home-container">
        <div data-role="Header" class="home-navbar-container">
          <div class="home-navbar">
             <div class="home-container1">
              <div class="home-cta-container">
                <div data-role="BurgerMenu" class="home-burger-menu">               
                </div>
              </div>
              <span class="home-text">2CSA Group 3 Shopping site&nbsp;</span>
            </div>
            <div class="home-logo"></div>
            <div class="home-cta-container">
                <button class="home-cta-btn button Anchor"><a href="login.jsp">Login</a></button>
              <div data-role="BurgerMenu" class="home-burger-menu">
                <svg viewBox="0 0 1024 1024" class="home-icon">
                  <path
                    d="M128 256h768v86h-768v-86zM128 554v-84h768v84h-768zM128 768v-86h768v86h-768z"
                  ></path>
                </svg>
              </div>
            </div>
            <div data-role="MobileMenu" class="home-mobile-menu">
              <div class="home-top">
                <img
                  alt="image"
                  src="image/default-img.svg"
                  class="home-image"
                />
                <div data-role="CloseMobileMenu" class="home-container1">
                  <svg viewBox="0 0 1024 1024" class="home-icon02">
                    <path
                     
                    ></path>
                  </svg>
                </div>
              </div>
              <div class="home-mid">
                <div class="home-links-container">
                  <span class="home-link Anchor">features</span>
                  <span class="home-link1 Anchor">services</span>
                  <a href="#about-us" class="home-link2 Anchor">About Us</a>
                  <span class="home-link3 Anchor">contact</span>
                </div>
                <button class="home-cta-btn1 Anchor button">
                  sTART BUILDING UHJHJ
                </button>
              </div>
              <div class="home-bot">
                <div class="home-social-links-container">
                  <svg viewBox="0 0 950.8571428571428 1024" class="home-icon04">
                    <path
                    
                    ></path></svg
                  ><svg
                    viewBox="0 0 877.7142857142857 1024"
                    class="home-icon06"
                  >
                    <path
                    ></path></svg
                  ><svg
                    viewBox="0 0 877.7142857142857 1024"
                    class="home-icon08"
                  >
                    <path
                    ></path>
                  </svg>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="home-hero">
          <div class="home-hero-text-container">
            <h1 class="home-heading Section-Heading">
              <span>Start ordering with us.</span>
              <br />
              <span>It's cheap.</span>
            </h1>
              <button class="home-cta-btn2 button Anchor"><a href="ShopServlet?category=All">START SHOPPING AS GUEST</a></button>
          </div>
          <img
            src="./image/image-500h.png"
            alt="image"
            class="home-image1"
          />
        </div>
        <div class="home-section-separator"></div>
        <div id="about-us" class="home-about-us">
          <div class="home-heading-container">
            <h2 class="home-text03 Section-Heading">
              What's the story behind our webapp?
            </h2>
          </div>
          <div class="home-text-container">
            <span class="home-text04">
              <span class="home-text05 Section-Text">
                Welcome to our webapp, your one-stop online destination for
                shopping online in the Philippines.
              </span>
              <br class="home-text06" />
              <span class="home-text07 Section-Text">
                We constantly update ourselves with the latest foods to make
                sure we offer you only the most exciting amazing food.
              </span>
              <br class="home-text08" />
              <span class="home-text09 Section-Text">
                At our webapp, we believe your shopping experience should be
                easy and fun.
              </span>
            </span>
          </div>
          <button class="home-cta-btn3 button Anchor">START BUILDING</button>
        </div>
        <div class="home-section-separator1"></div>
      </div>
    </div>
    
  </body>
</html>

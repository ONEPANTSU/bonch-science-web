$(document).ready(function () {

	"use strict"; // Start of use strict

	/*=======================================================
			NAVIGATION
    ========================================================*/

	$('nav').coreNavigation({
		menuPosition: "right", // left, right, center, bottom
		container: true, // true or false
		mode: 'fixed',
		onInit: function () {
			console.log('Init coreNav');
		}
	});

	$(window).on('scroll', function () {
		if ($(window).scrollTop() > 0) {
			$('nav').addClass('scrolled');
		} else {
			$('nav').removeClass('scrolled');
		}
	});

	/*=======================================================
			OWL CAROUSEL
    ========================================================*/

	$(".main-slider").owlCarousel({
		items: 1,
		nav: false,
		autoplay: true,
		loop: true,
		autoplayTimeout: 8000,
		autoplayHoverPause: true
	});

	$(".main-slider").on("translate.owl.carousel", function () {
		$(".slider-content h3, .slider-content h1, .slider-content a").removeClass("animated fadeInUp").css("opacity", "0");
	});
	$(".main-slider").on("translated.owl.carousel", function () {
		$(".slider-content h3, .slider-content h1, .slider-content a").addClass("animated fadeInUp").css("opacity", "1");
	});

	/*=======================================================
			OWL CAROUSEL TESTIMONIALS
    ========================================================*/

	$(".owl-testimonials").owlCarousel({
		items: 1,
		nav: false,
		autoplay: true,
		loop: true,
		autoplayTimeout: 8000,
		autoplayHoverPause: true
	});

	/*=======================================================
			WOW JS
    ========================================================*/

	new WOW().init();

	/*=======================================================
			PRELOADER
    ========================================================*/

	$(window).load(function () { // makes sure the whole site is loaded
		$('.preloader-holder .loader').fadeOut(); // will first fade out the loading animation
		$('.preloader-holder').delay(350).fadeOut('slow');
		// will fade out the white DIV that covers the website.
		$('body').delay(350).css({
			'overflow': 'visible'
		});
	});

});
'use strict';

document.addEventListener('DOMContentLoaded', function () {

	const menuIcon = document.querySelector('.menu-icon');
	const headerMenu = document.querySelector('.header-menu');
	const menuActive = false;

	menuIcon.addEventListener('click', function () {
		headerMenu.classList.toggle('_active');
		menuIcon.classList.toggle('_active');
		if (headerMenu.classList.contains('_active')) {
			disableScroll()
			// scrollTo(0, 0)
			// alert('da')
		} else {
			// document.style.overflow = 'hidden';
			enableScroll()
		}
	})


	// const arrowdStart = document.querySelector('.start-page__arrowd');
	// console.log(arrowdStart)
	// arrowdStart.addEventListener('click', function () {
	// 	let scrollInt = document.documentElement.clientHeight;
	// 	scrollTo(0, scrollInt);
	// })


	const tags = document.querySelector('.switcher-page__tags');

	tags.addEventListener('click', changeTag)
	// tags.addEventListener('touchstart', changeTag())

	function changeTag(e) {
		console.log(e.target)

		const target = e.target;
		const targetIdTag = target.dataset.idTag;
		const oldTag = document.querySelector('.switcher-page__tag._active');
		const choosenTag = tags.children[Number(targetIdTag) - 1];
		const oldContent = document.querySelector('.switcher-page__content._active')
		const content = document.querySelector('[data-id-cont$="' + targetIdTag + '"]');

		if (oldTag.classList.contains('_active_l')) {
			oldTag.classList.remove('_active_l');
		}
		if (oldTag.classList.contains('_active_r')) {
			oldTag.classList.remove('_active_r');
		}
		oldTag.classList.remove('_active');

		choosenTag.classList.add('_active');

		oldContent.classList.remove('_active');
		content.classList.add('_active');
	}


	const footerArrow = document.querySelector('.footer__arrow');
	footerArrow.addEventListener('click', function () {
		scrollTo(0, 0);
	})


})
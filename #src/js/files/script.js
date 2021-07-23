'use strict'

document.addEventListener('DOMContentLoaded', function () {
   // links
   const startPageBtns = document.querySelectorAll('.start-page__btn')

   for (let i = 0; i <= startPageBtns.length; i++) {
      $(startPageBtns[i]).on('click', function () {
         let a = i + 2
         $('html,body').animate({ scrollTop: $('#a' + a).offset().top + 'px' }, { duration: 1e3 })
      })
   }

   try {
      document.querySelector('#arrowDownF').addEventListener('click', () => {
         $('html,body').animate({ scrollTop: $('.footer').offset().top + 'px' }, { duration: 1e3 })
      })
   } catch (e) {}

   const headerNavItems = document.querySelectorAll('.header__nav-item')

   for (let i = 0; i <= headerNavItems.length; i++) {
      if (headerNavItems[0].firstChild.innerHTML == 'На главную') {
         $(headerNavItems[i]).on('click', function () {
            let a = i + 1
            $('html,body').animate({ scrollTop: $('#a' + a).offset().top + 'px' }, { duration: 1e3 })
         })
      } else {
         $(headerNavItems[i]).on('click', function () {
            let a = i + 2

            $('html,body').animate({ scrollTop: $('#a' + a).offset().top + 'px' }, { duration: 1e3 })
         })
      }
   }

   const footerLinks = document.querySelectorAll('.bottom-footer__items ul li a')
   for (let i = 0; i <= footerLinks.length; i++) {
      if (footerLinks[0].firstChild.innerHTML == 'На главную') {
         $(footerLinks[i]).on('click', function () {
            let a = i + 1
            $('html,body').animate({ scrollTop: $('#a' + a).offset().top + 'px' }, { duration: 1e3 })
         })
      } else {
         $(footerLinks[i]).on('click', function () {
            let a = i + 2
            $('html,body').animate({ scrollTop: $('#a' + a).offset().top + 'px' }, { duration: 1e3 })
         })
      }
   }

   $('.footer__arrow').on('click', function () {
      $('html,body').animate({ scrollTop: 0 }, { duration: 1e3 })
   })

   const arrowDownF = document.querySelector('.start-fazis__arrowd')
   const arrowDown = document.querySelector('.start-page__arrowd')
   const fazisLogoHeader = document.querySelector('.logo-header__logo')
   $(arrowDownF).on('click', function () {
      $('html,body').animate({ scrollTop: $('#a2').offset().top + 'px' }, { duration: 1e3 })
   })
   $(arrowDown).on('click', function () {
      $('html,body').animate({ scrollTop: $('#a2').offset().top + 'px' }, { duration: 1e3 })
   })
   $(fazisLogoHeader).on('click', function () {
      $('html,body').animate({ scrollTop: $('.header').offset().top + 'px' }, { duration: 1e3 })
   })

   const menuIcon = document.querySelector('.menu-icon')
   const headerMenu = document.querySelector('.header-menu')
   const menuActive = false
   const body = document.querySelector('body')

   menuIcon.addEventListener('click', function () {
      headerMenu.classList.toggle('_active')
      menuIcon.classList.toggle('_active')
      if (headerMenu.classList.contains('_active')) {
         body.classList.add('_lock')
      } else {
         body.classList.remove('_lock')
      }
   })
   if (document.documentElement.clientWidth <= 426) {
      headerNavItems.forEach((i) => {
         i.addEventListener('click', () => {
            headerMenu.classList.remove('_active')
            menuIcon.classList.remove('_active')
            body.classList.remove('_lock')
         })
      })
   }

   const tags = document.querySelector('.switcher-page__tags')

   tags.addEventListener('click', changeTag)
   // tags.addEventListener('touchstart', changeTag())

   function changeTag(e) {
      const target = e.target
      const targetIdTag = target.dataset.idTag
      const oldTag = document.querySelector('.switcher-page__tag._active')
      const choosenTag = tags.children[Number(targetIdTag) - 1]
      const oldContent = document.querySelector('.switcher-page__content._active')
      const content = document.querySelector('[data-id-cont$="' + targetIdTag + '"]')

      if (oldTag.classList.contains('_active_l')) {
         oldTag.classList.remove('_active_l')
      }
      if (oldTag.classList.contains('_active_r')) {
         oldTag.classList.remove('_active_r')
      }
      oldTag.classList.remove('_active')

      choosenTag.classList.add('_active')

      oldContent.classList.remove('_active')
      content.classList.add('_active')
   }

   const footerArrow = document.querySelector('.footer__arrow')
   footerArrow.addEventListener('click', function () {
      scrollTo(0, 0)
   })

   // popup

   const buttonCart = document.querySelectorAll('.item-carts__btn')
   const popup = document.querySelector('.popup')
   const close = document.querySelector('.popup__close')

   buttonCart.forEach(function (i) {
      let cartNum = i.dataset.cartNum
      i.addEventListener('click', function (e) {
         popup.classList.add('_active')
         body.classList.add('_lock')
         createSwiper(cartNum)
      })
   })

   function neededImgSrcs(cartNum) {
      switch (Number(cartNum)) {
         case 1:
            return ['img/certificates/database.png']
         case 2:
            return ['img/certificates/bi1.png', 'img/certificates/bi2.png']
         case 3:
            return ['img/certificates/hp1.png', 'img/certificates/hp2.png']
         case 4:
            return ['img/certificates/essbase.png']
         case 5:
            return ['img/certificates/inf1.png']
         case 6:
            return [
               'img/certificates/analyz1.png',
               'img/certificates/analyz2.png',
               'img/certificates/analyz3.png',
               'img/certificates/analyz4.png',
            ]
      }
   }

   function createSwiper(cartNum) {
      const sliderWrapper = document.querySelector('.swiper-wrapper')

      neededImgSrcs(cartNum).forEach((src) => {
         let slideDiv = document.createElement('div')
         slideDiv.classList.add('swiper-slide')

         let slideImg = document.createElement('img')
         slideDiv.append(slideImg)
         slideImg.src = src

         sliderWrapper.append(slideDiv)
      })

      const swiper = new Swiper('.swiper-container', {
         // Optional parameters
         centeredSlides: true,
         setWrapperSize: true,
         allowTouchMove: !(neededImgSrcs(cartNum).length === 1),
         // If we need pagination
         pagination: {
            el: '.swiper-pagination',
         },

         // Navigation arrows
         navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
         },

         pagination: {
            clickable: true,
            el: '.swiper-pagination',
         },

         // breakpoints: {
         //    1300: {
         //       allowTouchMove: false,
         //    },
         // },
      })

      document.querySelector('.popup').addEventListener('click', (e) => {
         if (e.target.classList.contains('popup')) {
            document.querySelectorAll('.swiper-slide').forEach((item) => {
               item.remove()
            })
            swiper.destroy()
         }
      })

      close.addEventListener('click', function () {
         document.querySelectorAll('.swiper-slide').forEach((item) => item.remove())
         popup.classList.remove('_active')
         body.classList.remove('_lock')
         swiper.destroy()
      })
   }
})

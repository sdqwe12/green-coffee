"use strict";(self.webpackChunkpwa=self.webpackChunkpwa||[]).push([[997],{6018:(n,e,i)=>{i.d(e,{N3:()=>a,h$:()=>o,uo:()=>r});var t=i(9802);const a=async(n,e)=>{try{let i;switch(n){case 1:i="/menu/coffee";break;case 2:i="/menu/beverage";break;case 3:i="/menu/food";break;case 4:i="/menu/goods"}const a=await t.Ay.get("".concat(i));e(a.data)}catch(i){console.log(i)}},o=async n=>{try{const e=(await t.Ay.get("/orders/list")).data;return n(e),console.log(e),e}catch(e){console.log(e)}},r=async(n,e)=>{try{const i=await t.Ay.post("/menu/detail",n);e(i.data)}catch(i){console.log(i)}}},6378:(n,e,i)=>{i.r(e),i.d(e,{default:()=>f});var t,a,o=i(9950),r=i(7528),l=i(6751),d=i(6066);const s=l.A.div(t||(t=(0,r.A)(["\n  padding-top: 35px;\n  .menu-wrap {\n    display: flex;\n    align-items: center;\n    gap: 10px;\n    border-bottom: 1px solid ",";\n    & .menu-tab {\n      display: flex;\n      justify-content: center;\n      align-items: center;\n      width: 50px;\n      height: 45px;\n      cursor: pointer;\n    }\n    & .menu-active {\n      display: flex;\n      justify-content: center;\n      align-items: center;\n      width: 50px;\n      height: 45px;\n      cursor: pointer;\n      border-bottom: 2px solid ",";\n    }\n    .search-wrap {\n      width: calc(100% - 260px);\n      display: flex;\n      justify-content: flex-end;\n    }\n    .search-icon {\n      color: ",";\n      cursor: pointer;\n    }\n  }\n  .bottom-info {\n    display: flex;\n    flex-direction: column;\n    padding: 30px 0 10px 10px;\n    span {\n      font-size: 16px;\n      font-weight: 500;\n      :last-of-type {\n        color: #9b9b9b;\n        font-size: 13px;\n      }\n    }\n  }\n"])),d.Tj.disabled,d.Tj.main,d.Tj.main),c=l.A.div(a||(a=(0,r.A)(["\n  width: 100%;\n  padding-top: 20px;\n  > div {\n    display: flex;\n    align-items: center;\n    flex-direction: column;\n    .box-wrap {\n      display: flex;\n      align-items: center;\n      gap: 15px;\n      width: 100%;\n      height: 120px;\n      border-bottom: 1px solid ",";\n      .box-img {\n        width: calc(23% - 20px);\n        height: 85px;\n        border-radius: 20px;\n        box-shadow: 1px 1px 10px 1px rgba(51, 51, 51, 0.5);\n        cursor: pointer;\n        img {\n          width: 100%;\n          height: 100%;\n          border-radius: 20px;\n          object-fit: fill;\n        }\n      }\n      .box-text {\n        width: 78%;\n        cursor: pointer;\n        > div {\n          :nth-of-type(1) {\n            font-size: 20px;\n            font-weight: 500;\n          }\n          :nth-of-type(2) {\n            font-size: 13px;\n            color: ",";\n          }\n          :nth-of-type(3) {\n            margin-top: 10px;\n          }\n        }\n      }\n    }\n  }\n"])),d.Tj.disabled,d.Tj.disabled);var p=i(6018),m=i(4414);const x=n=>{let{menuData:e,handleMenuClick:i}=n;return(0,m.jsx)(c,{children:(0,m.jsx)("div",{children:e.map((n=>{return(0,m.jsxs)("div",{className:"box-wrap",onClick:()=>i(n.category,n.menu_id,n.name),children:[(0,m.jsx)("div",{className:"box-img",children:(0,m.jsx)("img",{src:"".concat(n.menu_imgurl),alt:""})}),(0,m.jsxs)("div",{className:"box-text",children:[(0,m.jsx)("div",{children:n.name}),(0,m.jsx)("div",{children:n.menu_ename}),(0,m.jsxs)("div",{children:[(e=n.menu_price,e.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",")),"\uc6d0"]})]})]},n.menu_id);var e}))})})};var h=i(8429),g=i(4959),u=i(9324);const f=()=>{const[n,e]=(0,o.useState)(1),[i,t]=(0,o.useState)([]),a=(0,h.Zp)();return(0,o.useEffect)((()=>{(0,p.N3)(n,t)}),[n]),(0,m.jsxs)(s,{children:[(0,m.jsxs)("ul",{className:"menu-wrap",children:[[{id:1,mname:"\ucee4\ud53c"},{id:2,mname:"\uc74c\ub8cc"},{id:3,mname:"\ud478\ub4dc"},{id:4,mname:"\uc120\ubb3c"}].map((i=>(0,m.jsx)("li",{className:"menu-".concat(i.id===n?"active":"tab"),onClick:()=>{return n=i.id,void e(n);var n},children:(0,m.jsx)("span",{children:i.mname})},i.id))),(0,m.jsx)("li",{className:"search-wrap",children:(0,m.jsx)(g.g,{icon:u.$UM,className:"search-icon",onClick:()=>{a("/search")}})})]}),(0,m.jsx)(x,{menuData:i,handleMenuClick:(n,e,i)=>{a("/menudetail/".concat(n,"/").concat(e,"/").concat(i))}}),(0,m.jsxs)("div",{className:"bottom-info",children:[(0,m.jsx)("span",{children:"\uc720\uc758\uc0ac\ud56d"}),(0,m.jsx)("span",{children:"\u203b\uba54\ub274 \uc774\ubbf8\uc9c0\ub294 \uc774\ubbf8\uc9c0\ucef7\uc73c\ub85c \uc2e4\uc81c \uc74c\uc2dd\uacfc \ub2e4\ub97c \uc218 \uc788\uc2b5\ub2c8\ub2e4."})]})]})}},6066:(n,e,i)=>{i.d(e,{Tj:()=>b,gO:()=>w});var t,a,o,r,l,d,s,c,p,m,x,h=i(7528),g=i(6751);const u="@media only screen and (max-width: 1024px)",f="@media only screen and (max-width: 769px)",b={bar:"#F7F7F7",main:"#BF8A30",point:"#6A1B1B",green:"#009E73",red:"#EB5757",black:"#444444",white:"#ffffff",disabled:"#D9D9D9"},w={line1:{overflow:"hidden",whiteSpace:"nowrap",textOverflow:"ellipsis"},line2:{overflow:"hidden",whiteSpace:"normal",textOverflow:"ellipsis",display:"-webkit-box",WebkitLineClamp:"2",WebkitBoxOrient:"vertical"},line3:{overflow:"hidden",whiteSpace:"normal",textOverflow:"ellipsis",display:"-webkit-box",WebkitLineClamp:"3",WebkitBoxOrient:"vertical"}};g.A.div(t||(t=(0,h.A)(["\n  max-width: ",";\n  /* height: 100vh; */\n  display: flex;\n  flex-direction: column;\n  margin: 0 auto;\n\n  input,\n  textarea {\n    border: 1px solid ",";\n    border-radius: 1rem;\n    font-size: 1.2rem;\n  }\n\n  input::placeholder,\n  textarea::placeholder {\n    color: ",";\n  }\n"])),(n=>{n.maxw}),b.secondary,b.placeholder),g.A.div(a||(a=(0,h.A)(["\n  position: relative;\n  width: 100%;\n  padding: 0 2%;\n  background-color: ",";\n  display: flex;\n  height: 7.5rem;\n  justify-content: right;\n  align-items: center;\n  gap: 2rem;\n  z-index: 14;\n  border-bottom: 1px solid ",";\n  p {\n    font-size: 1.8rem;\n    color: ",";\n  }\n  .nav-logo {\n    width: 10rem;\n    display: block;\n    margin-right: auto;\n    display: none;\n    img {\n      width: 100%;\n    }\n  }\n  "," {\n    .nav-logo {\n      display: block;\n      margin-left: 3rem;\n    }\n  }\n"])),b.white,b.grayLight,b.greenDeep,f),g.A.div(o||(o=(0,h.A)(["\n  display: flex;\n  justify-content: flex-end;\n  align-items: center;\n  gap: 1rem;\n  "," {\n    .nav-btn {\n      display: none;\n    }\n  }\n"])),f),g.A.div(r||(r=(0,h.A)(["\n  position: relative;\n  padding: 3rem 2% 0;\n  height: calc(100vh - 7.5rem);\n  overflow-y: auto;\n  background: #fff\n    url(",") repeat top;\n"])),"/images/common/background.png"),g.A.div(l||(l=(0,h.A)(["\n  position: relative;\n  min-height: 100%;\n  margin: 0 auto 8rem;\n  z-index: 12;\n\n  input::placeholder,\n  textarea::placeholder {\n    color: ",";\n  }\n"])),b.placeholder),g.A.div(d||(d=(0,h.A)(["\n  max-width: 1300px;\n  margin: 0 auto;\n"]))),g.A.div(s||(s=(0,h.A)(["\n  background: #fff;\n  z-index: 99;\n  ","\n  "," {\n    .ant-menu-inline .ant-menu-submenu-title,\n    .ant-menu-light.ant-menu-inline .ant-menu-item {\n      padding: 1rem !important;\n    }\n    .ant-layout-sider {\n      min-width: auto !important;\n      width: 20rem !important;\n    }\n    .ant-layout-sider-collapsed {\n      min-width: 50px !important;\n      width: 50px !important;\n    }\n  }\n  "," {\n    position: absolute;\n    height: 100%;\n    left: 0;\n    top: 0;\n    .ant-layout-sider-collapsed {\n      min-width: 0 !important;\n      width: 0 !important;\n      img {\n        display: none;\n      }\n    }\n  }\n"])),{boxShadow:"0px 0px 5px 0px rgba(0, 0, 0, 0.1)",border:"1px solid rgba(0,0,0,0.02)"},u,f),g.A.div(c||(c=(0,h.A)(["\n  width: 100%;\n  text-align: center;\n  margin: 3rem 0;\n  img {\n    max-height: 3.5rem;\n  }\n"]))),g.A.div(p||(p=(0,h.A)(["\n  position: fixed;\n  left: 0;\n  bottom: 0;\n  width: 100%;\n  z-index: 13;\n\n  a {\n    position: absolute;\n    left: 50%;\n    bottom: 0.4rem;\n    transform: translateX(-50%);\n    font-size: 1.3rem;\n    color: #fff;\n  }\n"]))),g.A.h3(m||(m=(0,h.A)(["\n  padding-left: 2.8rem;\n  background: url(",")\n    no-repeat left 0.25rem/2.3rem;\n  color: ",";\n  a {\n    color: ",";\n  }\n"])),"/images/information/logo1.svg",b.greenDeep,b.greenDeep),g.A.div(x||(x=(0,h.A)(["\n  width: 100%;\n  padding: 3rem 2rem;\n  font-size: 1.6rem;\n  border-radius: 1rem;\n  background: #f7f7f7;\n  margin: 2rem 0;\n  text-align: center;\n  border: 1px solid ",";\n\n  p {\n    margin-bottom: 2rem;\n    line-height: 1.5;\n  }\n  b {\n    font-size: 400;\n    color: ",";\n  }\n  small {\n    display: block;\n    margin-top: 0.5rem;\n    font-size: 1.4rem;\n    color: ",";\n  }\n  .ant-input-group-wrapper {\n    margin: 0 auto;\n    display: block;\n    max-width: 50rem;\n  }\n"])),b.grayBar,b.greenDeep,b.grayDeep)}}]);
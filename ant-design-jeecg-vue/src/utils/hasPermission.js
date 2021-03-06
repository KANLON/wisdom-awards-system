const hasPermission = {
    install (Vue) {
          Vue.directive('has', {
            inserted: (el, binding, vnode)=>{
              let permissionList = vnode.context.$route.meta.permissionList;
              if (permissionList === null || permissionList === "" || permissionList === undefined) {
                el.parentNode.removeChild(el)
              }
              let permissions = [];
              for (var item of permissionList) {
                permissions.push(item.action);
              }
              //console.log("页面权限----"+permissions);
              //console.log("页面权限----"+binding.value);
              if (!permissions.includes(binding.value)) {
                //if(el.parentNode)
                el.parentNode.removeChild(el)
              }
            }
          });
    }
};

export default hasPermission;

var teachersInformationModule = angular.module('teachersInformationModule', []);
teachersInformationModule.controller('teachersInformationController', teachersInformationController);

function teachersInformationController($http,$scope) {


  var table = $('#table');
  table.bootstrapTable({
    contextMenu: '#example1-context-menu',
    onContextMenuItem: function(row, $el){
      if($el.data("item") == "edit"){
        alert("Edit: " + row.id + ' ' + row.firstName + ' ' + row.lastName);
      } else if($el.data("item") == "delete"){
        alert("Delete: " + row.id + ' ' + row.firstName + ' ' + row.lastName);
      } else if($el.data("item") == "action1"){
        alert("Action1: " + row.id + ' ' + row.firstName + ' ' + row.lastName);
      } else if($el.data("item") == "action2"){
        alert("Action2: " + row.id + ' ' + row.firstName + ' ' + row.lastName);
      }
    }
  });
}

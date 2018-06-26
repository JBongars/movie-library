myApp.controller('WelcomeController', [ function(){
    console.log("Welcome Controller started!");
}]);

myApp.controller('MoviesController', ['$http', function($http){
    console.log("Movies controller started!");

    let vm = this; //vm

    // Set the Content-Type 
    //$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
        
    // Delete the Requested With Header
    delete $http.defaults.headers.common['X-Requested-With'];

    const imbd = "http://omdbapi.com/";
    const api = "http://localhost:8080/api/movies/";

    vm.imageSortableOptions = {
        'ui-floating': true,
        'update': function (event, ui) {
            callApi(vm.item, 'update');
        }
    }

    vm.types = ["Horror", "Romance", "Action", "Thriller", "Historical", "Family"];
    vm.fields = {};
    vm.index;
    vm.filter = {};
    vm.item = [];

    vm.listMovies = listMovies;
    vm.getImbdMovies = getImbdMovies;
    vm.loadUpdate = loadUpdate;
    vm.deleteItem = deleteItem;
    vm.submitForm = submitForm;
    vm.changeState = changeState;

    function init(){
        listMovies();
    }
    init();
    
    function listMovies(){
        vm.filter = {};
        console.log('getting movies..');
        $http.get(api + 'list').then(results => {
            console.log('results are: ', results);
            vm.item = results.data;
        })
    }

    function callApi(items, state){
        let call;
        switch(state){
            case "delete":
            case "update": 
                call = { url: api + 'update', method: "POST", data: angular.toJson(items) };
                break;
            case "create": 
                call = { url: api, method: "POST", data: angular.toJson(items) };
                break;
        }

        console.log('making call: ', call.data);

        if(call){
            console.log('updating...', items);
            $http(call).then(results => {
                console.log('items are updated: ', results);
                listMovies();
            })
        } else {
            console.log('no item selected!');
        }
    }

    let imbdTimer;
    function getImbdMovies(){
        clearTimeout(imbdTimer);
        imbdTimer = setTimeout(() => {
            $http.get(imbd, {
                params: {
                    apikey: "1e6cb687",
                    t: vm.fields.title
                }
            }).then(results => {
                console.log('results are: ', results);
                vm.imbdMovies = results.data;
                
            });
        }, 1000);
    }

    function changeState(state){
        vm.state = state;
        vm.fields = {};
    }

    function loadUpdate(item, index){
        changeState('update');
        vm.fields = Object.assign({}, item);
        vm.index = index;
    }

    function deleteItem(index){
        vm.item.splice(index, 1);
        callApi(vm.item, 'delete');
    }

    function submitForm(){
        console.log("fields form is: ", vm.fields);

        switch(vm.state){
            case 'search':
                vm.filter = Object.assign({}, vm.fields);
                break;
            case 'update':
                vm.item[vm.index] = Object.assign({}, vm.fields);
                console.log('vm item is: ', vm.item);
                callApi(vm.item, 'update');
                break;
            case 'create':
                vm.item.push(Object.assign({}, vm.fields));
                callApi(Object.assign({}, vm.fields), 'create');
                break;
            default:
        }
        changeState();
    }

}]);
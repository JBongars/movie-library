myApp.controller('WelcomeController', [ function(){
    console.log("Welcome Controller started!");
}]);

myApp.controller('MoviesController', ['$http', function($http){
    console.log("Movies controller started!");

    let vm = this; //vm

    // Set the Content-Type 
    // $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
        
    // Delete the Requested With Header
    delete $http.defaults.headers.common['X-Requested-With'];

    const imbd = "http://omdbapi.com/";
    const api = "http://localhost:8080/api/movies";

    vm.types = ["Horror", "Romance", "Action", "Thriller", "Historical", "Family"];
    vm.fields = {};
    vm.index;
    vm.filter = {};
    vm.item = [];

    vm.listMovies = listMovies;
    vm.getImbdMovies = getImbdMovies;
    vm.loadUpdate = loadUpdate;
    vm.submitForm = submitForm;
    vm.updateMovies = updateMovies;
    vm.changeState = changeState;

    function init(){
        listMovies();
    }
    init();
    
    function listMovies(){
        console.log('getting movies..');
        $http.get(api + '/list').then(results => {
            console.log('results are: ', results);
            vm.item = results.data;
        })
    }

    function updateMovies(items){
        items = angular.toJson(items);
        console.log('updating...', items);
        $http.post(api + '/update', {}, items).then(results => {
            console.log('items are updated: ', results);
            listMovies();
        })
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

    function submitForm(){
        console.log("fields form is: ", vm.fields);

        switch(vm.state){
            case 'search':
                vm.filter = Object.assign({}, vm.fields);
                break;
            case 'update':
                vm.item[vm.index] = Object.assign({}, vm.fields);
                console.log('vm item is: ', vm.item);
                updateMovies(vm.item);
                break;
            case 'create':
                break;
            default:
        }
        changeState();
    }

}]);
myApp.controller('WelcomeController', [ function(){
    console.log("Welcome Controller started!");
}]);

myApp.controller('MoviesController', ['$http', function($http){
    console.log("Movies controller started!");

    let vm = this; //vm

    const imbd = "http://omdbapi.com/";
    const api = "localhost:8080/api/movies";

    vm.types = ["Horror", "Romance", "Action", "Thriller", "Historical", "Family"];
    vm.fields = {};

    vm.getMovies = getMovies;
    vm.getImbdMovies = getImbdMovies;
    vm.submiForm = submiForm;
    vm.changeState = changeState;
    



    function getMovies(){
        console.log('getting movies..');
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

    function submiForm(){
        console.log("search form is: ", vm.search);

        switch(vm.state){
            case 'search':
                break;
            case 'create':
                break;
            default:
        }
        changeState();
    }

    vm.movies = [
        {
          "title": "Ocean's 8",
          "director": "Gary Ross",
          "releaseDate": "13/06/2018",
          "type": "action"
        },
        {
          "title": "Solo: A Star Wars Story",
          "director": "Ron Howard",
          "releaseDate": "23/05/2018",
          "type": "Sci-Fi"
        },
        {
          "title": "Deadpool 2",
          "director": "David Leitch",
          "releaseDate": "16/05/2018",
          "type": "Comedy"
        },
        {
          "title": "Avengers: Infinite War",
          "director": "Anthony Russo, Joe Russo",
          "releaseDate": "25/04/2018",
          "type": "action"
        },
        {
          "title": "The First Purge",
          "director": "Gerard McMurray",
          "releaseDate": "04/07/2018",
          "type": "Horror"
        },
        {
          "title": "Mission: Impossible - Fallout",
          "director": "Christopher McQuarrie",
          "releaseDate": "01/08/2018",
          "type": "Thriller"
        },
        {
          "title": "The Mummy",
          "director": "Christopher McQuarrie",
          "releaseDate": "14/06/2017",
          "type": "Fantasy"
        },
        {
          "title": "Hunger Games",
          "director": "Gary Ross",
          "releaseDate": "21/03/2012",
          "type": "Thriller"
        },
        {
          "title": "John Wick",
          "director": "David Leitch",
          "releaseDate": "29/10/2014",
          "type": "Thriller"
        }
    ]


}]);
import {inject} from 'aurelia-framework';



export class App {


	constructor() {
	    

	  }

	configureRouter(config, router) {
	    this.router = router;
	    config.title = 'PASHION';
	    config.map([

	      { route: ['', '/'],       name: 'guestpage',       moduleId: 'guestpage' }
	      
	    ]);
  	}

    activate() {
	    }
  
}

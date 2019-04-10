import { Component, OnInit } from '@angular/core';
import { CategoryServiceService } from 'src/app/services/category-service.service';
import { Category } from 'src/app/domain/category';
import { StateServiceService } from 'src/app/services/state-service.service';
import { State } from 'src/app/domain/state';
import { Search } from 'src/app/domain/search';
import { CharityServiceService } from 'src/app/services/charity-service.service';
import { Charity } from 'src/app/domain/charity';
import {SelectItem} from 'primeng/api';

interface City {
  name: string;
  code: string;
}

@Component({
  selector: 'app-charity',
  templateUrl: './charity.component.html',
  styleUrls: ['./charity.component.scss']
})

export class CharityComponent implements OnInit {

  displayDialog: boolean; 
  selectedState: State;
  category: Category = {};
  
  state: State = {};

  categories: SelectItem[];
  
  searchObject: Search = {};

  charities: Charity[];

  cols: any[];

  charity: Charity = {};

  states: SelectItem[];
  


  constructor(private categoryService: CategoryServiceService,
    private stateService: StateServiceService, private charityService: CharityServiceService) { }

  ngOnInit() {
    this.states = [];
    this.states.push({label: 'Select State', value: null});

    this.categories = [];
    this.categories.push({label: 'Select Category', value: null});

    this.categoryService.getCategories().then(categories =>  {
      categories.forEach(category => {        
        this.categories.push({label: category.categoryValue, value : category.categoryKey})        
      });
    });

    this.stateService.getUsStates().then(states => {      
      states.forEach(state => {        
        this.states.push({label: state.stateKey, value : state.stateValue})        
      });
    });
                       
      this.cols = [
          { field: 'charityName', header: 'Name' },
          { field: 'city', header: 'City' },
          { field: 'state', header: 'State' }          
      ];

   }


   searchCharities(search:Search){
    
    if(this.searchObjectTreatment(search)){          
      this.charityService.getCharities(search).then(charities => this.charities = charities);
    }
   }


   searchObjectTreatment(search:Search){
      if(search.category == null) {
        delete search.category;
      }
      if(search.city == null||search.city == '') {
        delete search.city; 
      }
      if(search.state == null) {
        delete search.state;
      } 
      if(search.searchTerm == null||search.searchTerm == '') {
        delete search.searchTerm;
      }
             
      if(search.category == undefined &&
        search.city == undefined && search.state == undefined && search.searchTerm == undefined){
        return false;
      }
      return true;
   }


  
  onRowSelect(event) {               
      this.charity = event.data;
      this.displayDialog = true;
      
  }

  
  
  exit(){
    this.displayDialog = false;
  }

}

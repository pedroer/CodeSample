import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Charity } from '../domain/charity';
import {Search} from '../domain/search';

@Injectable({
  providedIn: 'root'
})
export class CharityServiceService {


  constructor(private http: HttpClient) { }
  
  getCharities(searchObject: Search){
  return  this.http.post<any>('http://localhost:8080/charity', searchObject).toPromise()
      .then(res => <Charity[]>res)
      .then(data => { 
        return data; });
      }

}

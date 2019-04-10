import { Injectable } from '@angular/core';
import { State } from '../domain/state';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StateServiceService {

  constructor(private http: HttpClient) { }

    getUsStates() {

    return this.http.get<any>('http://localhost:8080/state')
      .toPromise()
      .then(res => <State[]>res)
      .then(data => { 
        return data; });
    }

}

import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpService} from '../http.service';
import {Observable} from 'rxjs';
import {People} from './people';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PeopleService {

  constructor(private http: HttpClient) { }

  getAllPeople(): Observable<People[]>{
     return this.http.get(HttpService.SERVICE_PATH + '/people', HttpService.httpOptions)
      .pipe(map(response => response as People[]));
  }

  searchPeople(peopleName: string): Observable<People[]>{
    return this.http.get(HttpService.SERVICE_PATH + '/people/search?personName=' + peopleName, HttpService.httpOptions)
      .pipe(map(response => response as People[]));
  }

}

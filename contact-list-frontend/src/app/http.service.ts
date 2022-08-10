import {HttpHeaders} from '@angular/common/http';
import {environment} from '../environments/environment';

export class HttpService {
  static SERVICE_PATH = environment.apiUrl;

  static httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
}

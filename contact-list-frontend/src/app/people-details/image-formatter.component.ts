import { Component } from '@angular/core';

@Component({
  selector: 'app-image-formatter-cell',
  template: `<img border="0" width="20%" height="20%" src=\"{{ params.value }}\">` })

export class ImageFormatterComponent {
  params: any;
  // tslint:disable-next-line:typedef
  agInit(params: any){
    this.params = params;
  }
}

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { TestsOverviewComponent } from './tests-overview/tests-overview.component';


@NgModule({
  declarations: [
    AppComponent,
    TestsOverviewComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

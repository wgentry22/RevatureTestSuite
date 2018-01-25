import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TestsOverviewComponent } from './tests-overview/tests-overview.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { AppRoutingModule } from './/app-routing.module';
import { TestDetailComponent } from './test-detail/test-detail.component';
import { GroupDetailComponent } from './group-detail/group-detail.component';
import { MetricsViewComponent } from './metrics-view/metrics-view.component';


@NgModule({
  declarations: [
    AppComponent,
    TestsOverviewComponent,
    SidenavComponent,
    TestDetailComponent,
    GroupDetailComponent,
    MetricsViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

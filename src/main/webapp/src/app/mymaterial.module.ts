import { NgModule } from "@angular/core";
import { MatButtonModule, MatCardModule, MatToolbarModule, MatFormFieldModule, MatFormField, MatInputModule } from "@angular/material";
import { CommonModule } from "@angular/common";

@NgModule({
  imports: [
      CommonModule,
      MatButtonModule,
      MatCardModule,
      MatToolbarModule,
      MatFormFieldModule,
      MatInputModule
  ],
  exports: [
      CommonModule,
      MatButtonModule,
      MatCardModule,
      MatToolbarModule,
      MatFormFieldModule,
      MatInputModule
    //   MatFormField
  ]  
})
export class MyMaterialModule { }
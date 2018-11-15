import { NgModule } from "@angular/core";
import { MatButtonModule, MatCardModule, MatToolbarModule, MatFormFieldModule, MatFormField, MatInputModule, MatIconModule, MatListModule } from "@angular/material";
import { CommonModule } from "@angular/common";

@NgModule({
  imports: [
      CommonModule,
      MatButtonModule,
      MatCardModule,
      MatToolbarModule,
      MatFormFieldModule,
      MatInputModule,
      MatToolbarModule
  ],
  exports: [
      CommonModule,
      MatButtonModule,
      MatCardModule,
      MatToolbarModule,
      MatFormFieldModule,
      MatInputModule,
      MatToolbarModule,
      MatIconModule,
      MatListModule
    //   MatFormField
  ]  
})
export class MyMaterialModule { }
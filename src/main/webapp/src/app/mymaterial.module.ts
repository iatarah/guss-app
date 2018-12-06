import { NgModule } from "@angular/core";
import { MatButtonModule, MatCardModule, MatToolbarModule, MatFormFieldModule, MatFormField, MatInputModule, MatIconModule, MatListModule, MatMenuModule, MatMenu } from "@angular/material";
import { CommonModule } from "@angular/common";

@NgModule({
  imports: [
      CommonModule,
      MatButtonModule,
      MatCardModule,
      MatToolbarModule,
      MatFormFieldModule,
      MatInputModule,
      MatToolbarModule,
      MatMenuModule
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
      MatListModule,
      MatMenuModule
    //   MatFormField
  ]  
})
export class MyMaterialModule { }
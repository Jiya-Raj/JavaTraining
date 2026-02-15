import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './product.html',
  styleUrls: ['./product.css']
})
export class ProductComponent implements OnInit {

  private baseUrl = 'http://localhost:8080/product';

  products: any[] = [];
  product: any = {};
  isEditing: boolean = false;
  editId: string = '';

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.loadProducts();
  }

  loadProducts() {
    this.http.get(this.baseUrl).subscribe(data => {
      this.products = data as any[];
    });
  }

  saveProduct() {

    if (this.isEditing) {
      // UPDATE
      this.http.put(`${this.baseUrl}/${this.editId}`, this.product)
        .subscribe(() => {
          this.resetForm();
          this.loadProducts();
        });

    } else {
      // CREATE
      this.http.post(this.baseUrl, this.product)
        .subscribe(() => {
          this.resetForm();
          this.loadProducts();
        });
    }
  }

  editProduct(p: any) {
    this.product = { ...p };
    this.editId = p._id;
    this.isEditing = true;
  }

  deleteProduct(id: string) {
    this.http.delete(`${this.baseUrl}/${id}`)
      .subscribe(() => {
        this.loadProducts();
      });
  }

  resetForm() {
    this.product = {};
    this.isEditing = false;
    this.editId = '';
  }
}

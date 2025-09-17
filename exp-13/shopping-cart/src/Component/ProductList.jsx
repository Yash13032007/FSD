import React from "react";
import laptopImg from "../assets/laptop.jpg";
import headphonesImg from "../assets/headphone.jpg";
import mobileImg from "../assets/mobile.jpg";

const products = [
  { id: 1, name: "Laptop", price: 60000, image: laptopImg },
  { id: 2, name: "Headphones", price: 2000, image: headphonesImg },
  { id: 3, name: "Mobile Phone", price: 25000, image: mobileImg },
  { id: 4, name: "Mobile Phone", price: 55000, image: mobileImg },
];
const ProductList = ({ addToCart }) => {
  return (
    <div>
      <h2>Products</h2>
      <div style={{ display: "flex", gap: "20px" }}>
        {products.map((product) => (
          <div key={product.id} style={{ border: "1px solid #ccc", padding: "10px" }}>
            <img src={product.image} alt={product.name} width="150" />
            <h3>{product.name}</h3>
            <p>Price: ₹{product.price}</p>
            <button onClick={() => addToCart(product)}>Add to Cart</button>
          </div>
        ))}
      </div>
    </div>
  );
};
export default ProductList;
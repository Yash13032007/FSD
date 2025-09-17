import { BrowserRouter, Routes, Route } from "react-router-dom";
// import Home from "./pages/Home";
import Home from './pages/Home'
import About from "./pages/About";
import Navbar2 from "./pages/Navbar2";

const App = () => {
  return (
    <BrowserRouter>
    <h1>welcome to my react app!</h1>
      <Navbar2 />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/home" element={<Home />} />
        <Route path="/about" element={<About />} />
      </Routes>
    </BrowserRouter>
  );
};
export default App;
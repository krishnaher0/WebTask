
import GroundForm from './components/GroundData.jsx'
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Sidebar from './components/Sidebar.jsx';
import Dashboard from './components/Dashboard.jsx';
import './main.css';
import BookingData from "./components/BookingData.jsx";
import UserForm from "./components/UserForm.jsx";




function App() {

    return (
        <>
            <Router>
                <div className="flex  h-screen bg-white dark:bg-zinc-200">
                    <section className="">
                        <Sidebar />
                    </section>
                    <section className="grow  overflow-auto">
                        <Routes>
                            <Route path="/" element={<Dashboard />} />
                            <Route path="/book" element={<BookingData />} />
                            <Route path="/ground" element={<GroundForm />} />
                            <Route path="/user" element={<UserForm />} />


                        </Routes>
                    </section>
                </div>
            </Router>
        </>
    )
}

export default App
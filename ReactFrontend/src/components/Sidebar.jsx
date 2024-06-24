import React from "react";
import { Link } from "react-router-dom";
import { RiDashboardFill } from "react-icons/ri";
import { MdPeopleAlt } from "react-icons/md";
import { GrTransaction } from "react-icons/gr";
import { IoLogOut } from "react-icons/io5";

function Sidebar() {
    return (
        <div className="h-screen bg-slate-200 dark:bg-white">
            <div className="flex flex-col gap-3 w-full text-slate-300 h-full justify-between">
                <div className="flex flex-col gap-10 px-4 mt-4">
                    <div className="flex items-center justify-center gap-3">
                        <div className="block md:hidden">
                            {/* <img src={Home} alt="Dumbbell" /> */}
                        </div>
                        <div className="hidden md:block w-32 h-auto ">
                            {/* <img src={Logo} alt="Logo" className="w-[100px]" /> */}
                        </div>
                    </div>
                    <div className="flex flex-col gap-10 text-md sm:text-sm lg:text-lg ">
                        <Link to="/" className="flex items-center gap-3">
                            <RiDashboardFill className="text-2xl text-black"/>
                            <span className="hidden sm:flex text-slate-600 hover:text-slate-400 cursor-pointer font-Roboto">
                                Dashboard
                            </span>
                        </Link>
                        <Link to="/book" className="flex items-center gap-3">
                            <MdPeopleAlt className="text-2xl text-black" />
                            <span className="hidden font-Roboto sm:flex text-slate-600 hover:text-slate-400 cursor-pointer">
                                Book
                            </span>
                        </Link>
                        <Link to="/ground" className="flex items-center gap-3">
                            <GrTransaction className="text-2xl text-black"/>
                            <span className="hidden sm:flex text-slate-600 hover:text-slate-400 cursor-pointer">
                                Ground
                            </span>
                        </Link>
                    </div>
                </div>

                <div className="flex items-center text-md text-slate-600 hover:text-slate-400 sm:text-xs md:text-sm lg:text-lg px-4 mb-4 gap-3">
                    <IoLogOut className="text-md text-black"/>
                    <span className="hidden font-Roboto sm:flex">Logout</span>
                </div>
            </div>
        </div>
    );
}

export default Sidebar;

#!/bin/bash
# ==============================================================================
# COOS Experiment 4B: Linux Shell Script
# Prepared by: Aaryan Choube (24CE1045) | Batch A/A1
# Requirements:
# a. Display OS version, release number, kernel version
# b. Display top 10 processes in descending order
# c. Display processes with highest memory usage
# d. Display current logged in user and log name
# e. Display current shell, home directory, OS type, path setting, working dir
# ==============================================================================

clear
echo "================================================================="
echo "   COOS LAB EXP 4B - SYSTEM INFORMATION SHELL SCRIPT"
echo "================================================================="

echo ""
echo "[a] Operating System & Kernel Version Details:"
echo "--------------------------------------------------"
echo "Operating System : $(uname -o)"
echo "Kernel Name      : $(uname -s)"
echo "Kernel Release   : $(uname -r)"
echo "Kernel Version   : $(uname -v)"
if [ -f /etc/os-release ]; then
    echo "Distribution     : $(grep PRETTY_NAME /etc/os-release | cut -d= -f2 | tr -d '"')"
fi

echo ""
echo "[b] Top 10 Processes in Descending Order of CPU Usage:"
echo "--------------------------------------------------"
ps -eo pid,ppid,user,%cpu,%mem,comm --sort=-%cpu | head -n 11

echo ""
echo "[c] Processes with Highest Memory Usage:"
echo "--------------------------------------------------"
ps -eo pid,user,%mem,%cpu,comm --sort=-%mem | head -n 11

echo ""
echo "[d] Current Logged-in User & Log Name:"
echo "--------------------------------------------------"
echo "Current User (whoami) : $(whoami)"
echo "Login Name (logname)  : $(logname 2>/dev/null || whoami)"
echo "Active Login Sessions :"
who

echo ""
echo "[e] Environment & Working Directory Settings:"
echo "--------------------------------------------------"
echo "Current Shell     : $SHELL"
echo "Home Directory    : $HOME"
echo "OS Type           : $OSTYPE"
echo "Current Directory : $(pwd)"
echo "Current PATH      : $PATH"
echo "================================================================="

## Path Tracking of PC Controlled Robot

Over the past decade, there has been a steady increase in the number of applications that demand customized computer systems that offer 
high performance at low cost. These applications are, more often than not, characterized by the need to process large amounts of data in 
real time. Examples include consumer electronics, scientific computing, and signal processing systems. 

Evolutions have also been rapid in robotics and embedded systems which are useful in developing machines that can substitute a human
presence. An embedded system is a "behind the scenes" computer which, when combined with resident software applications, provides 
functionality typically focused on a single, specialized purpose. In this project we are trying to make an attachment between the 
Embedded system and Java Swings so that the user can interact and at the same time track the Path followed by the Robot.
The project focuses on using a robot and IR sensors to find out the Graphical path followed by that Robot by using a mix of Hardware with 
Software. By this we can directly view the motion or path followed by the robot by the use of Graphical User Interface(GUI) which I've
developed. The user can directly control the Robot by the PC remote. This method reduces human interaction with the objects. 

The robot has been designed with a peripheral microcontroller (PIC1650 developed by General Instruments) at its heart. It consists of a 
H-bridge which a electric voltage circuit. IR(Infrared) sensors are fitted across the device which emits and detects the surroundings. 
The robot is also fitted with an XBEE RF modem which implements Zigbee protocol for communication with a remote and the user commands. It 
is through this protocol that the user can communicate wirelessly to change the direction of a robot and also plot the path it travels.

Eclipse software has been used in order to develop our GUI. Eclipse is a community for individuals and organizations who wish to collaborate
on commercially-friendly open source software. Its projects are focused on building an open development platform comprised of extensible 
frameworks, tools and runtimes for building, deploying and managing software across the lifecycle. I have established the serial 
communication between the robot and front end GUI in eclipse using port communication. Swing is the Java platform's UI - it acts as the 
software to handle all the interaction between a user and the computer. 

This project idea can be implemented in various newly developing technologies in the field of traffic and military purposes. 
Implementation of this method will provide an immersive advantage and also provides more efficiency usage of human resources and reduces 
the burden to check everything in the presence of a human.

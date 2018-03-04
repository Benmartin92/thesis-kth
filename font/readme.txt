	MATHTIME PROFESSIONAL 2 INSTALLER FOR TEX LIVE SYSTEMS ON UNIX (including Mac OSX)


This installer is copyright James Fennell and is released under
the Apache 2 license.

Contact: james.fennell@cims.nyu.edu.


1) INTRODUCTION

MathTime Professional 2 is a set of math fonts that can be used, with a 
text font of your choice, to replace the standard Computer Modern fonts 
in TeX/LaTeX. They were created by Michael Spivak of Publish Or Perish. 
They are designed to be most compatible with various Times New Roman 
families, such as the built in TeX Gyre Termes, but also work well with
other families, such as Baskerville. A good description of the difference
between MathTime and Computer Modern is given in this document 

	[1] http://cims.nyu.edu/~fennell/mtpro2/for%20TeX/LaTeX

by Michael Spivak, from the PCTeX website.


2) INSTALLING MATHTIME PROFESSIONAL 2

This is an installer for the MathTime fonts that works for Linux or
Mac OS X systems running the TeX Live or MacTeX distributions. Unless 
your Linux or Mac operating system is very old your TeX installation is 
probably TeX Live.

To install the fonts you first need to aquire a copy of the font files 
from PCTeX, here:

	[2] http://www.pctex.com/mtpro2.html

They will come in .zip.tpm format. The complete version must be purchased; 
however a free "lite" version is also available. This installer works
with either.

Next you should copy the MTPro2 installer file, mtpro-texlive.sh. The 
easiest thing is to save both the font files and the installer into 
your Home directory.

Now open a terminal. If you've saved the font files in a location other 
than your Home directory you will need to `cd` into that directory. Now 
you must make the installer an executable file by running

	chmod +x ./mtpro2-texlive.sh

Then run the installation procedure by typing

	./mtpro2-texlive.sh -i [PATH TO FONT FILES]

For example, if you've saved the font files and the installer in the 
same location (hint hint) the command will be

	./mtpro2-texlive.sh -i mtp2lite.zip.tpm

The following is the output of a succesful install:

	user@user-laptop-1404:~$ mtpro2-texlive.sh -i mtp2lite.zip.tpm
	Unpacking mtp2lite.zip.tpm.
	[sudo] password for user: 
	Copying files.
	Installing MathTime Professional 2.
	  > running texhash
	  > updating map references
	  > editing updmap.cfg
	  > updating TeX Live databases
	TeX Live updated; checking that MTPro2 works...
	Succesfully compiled LaTeX file with MTPro2 included.
	MathTime Professional 2 installed.
	Documentation available at /usr/local/share/texmf/docs/	

If the installation fails you should consult the install log file, 
at mtpro2-texlive.sh.log. You can email me, or post a question on 
Tex.StackExchange.

For instructions on how to use the other features of the installer run

	./mtpro2-texlive.sh -h


3) USING MATHTIME PROFESSIONAL 2

To use MathTime you must pair it with a text font. MathTime is designed 
to work well with Times New Roman text fonts. A natural choice is the 
built in TeX Gyre Termes. To use MathTime with this text font you should 
include the following commands in the header of your LaTeX document:

	\usepackage{tgtermes}
	\usepackage[T1]{fontenc}
	\usepackage{amsmath}
	\usepackage[lite,subscriptcorrection,slantedGreek,nofontinfo]{mtpro2}

If you have the complete version of MathTime you need not include the 
amsmath package, and should omit the lite option from the mtpro2 include.

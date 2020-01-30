# How we created a USB Stick with the exercises on it

## USB Make Remix with Pinguy

We followed [this article](http://pinguyos.com/2015/09/pinguy-builder-an-app-to-backupremix-buntu/) to make an ISO file containing an Ubuntu with Eclipse, IntelliJ, keyboard layouts and exercises.

It boils down to this:

* Have an Ubuntu installed
* Set up your environment with Eclipse, IntelliJ, Visual Studio Code, git, azerty and qwerty keyboard layouts and the exercises
* Make sure you can run unit tests in both Eclipse and IntelliJ
* Also make sure the git credentials are gone (no lingering ssh keys etc.)
* git init with an initial commit on the exercises dir so our candidates can commit.

**Keep into account that your credentials to the WiFi will be saved, and will be used when running the Live USB when testing a candidate.**

## How to create a bootable USB stick with a regular Ubuntu on it

[On Windows](https://www.ubuntu.com/download/desktop/create-a-usb-stick-on-windows)

[On OSX](https://www.ubuntu.com/download/desktop/create-a-usb-stick-on-mac-osx)

## After you installed Ubuntu

Update your Ubuntu with the latest patches/upgrades.

Also install IntelliJ, Eclipse, Visual Studio Code, Git and Java on this Ubuntu.

Make sure there are 2 languages (qwerty and azerty).

If you don't want any WiFi (or other) credentials saved, now is the time to delete them.

### Install Pinguy Builder
Download [Pinguy Builder](https://sourceforge.net/projects/pinguy-os/files/ISO_Builder/pinguybuilder_4.3-8_all-beta.deb/download).

If installing it using the Ubuntu GUI doesn't work, you'll have to `dpkg -i pinguybuilder_4.3-8_all-beta.deb` from a terminal.

### Create a _backup_ using Pinguy Builder
Make sure `home/PinguyBuilder` does not exist before you do anything.

Click setup, fill in _cgktech_...

Click on `backup` (not `dist` as it will not copy your language settings etc.).

This will eventually create an .iso in `/home/PinguyBuilder/PinguyBuilder/cgktech-backup.iso`

### Use Startup Disk Creator to create a Live USB

Select the iso in `/home/PinguyBuilder/PinguyBuilder/cgktech-backup.iso`

Click Make Startup Disk, click Yes, and wait.

The bar will complete to 100% pretty quickly, and will seemingly stall on _Finishing..._.

Just wait until that process is complete, it will take a while, but will show a popup saying

> Installation is complete. You may now run Ubuntu on other computers by booting them with this drive inserted.

### Test the Live USB
Plug in the USB, boot on a regular laptop by spamming `esc` or `ins` or `del` or whatever the boot screen says. Then choose boot options or something and choose boot from USB.

On a Mac you can boot from USB by completely turning off your mac, plugging in the USB, restarting your mac and holding down `alt` (`option`) right after you hear the startup sound. That will allow you to select the USB as a boot device.
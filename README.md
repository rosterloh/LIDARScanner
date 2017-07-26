# LIDAR Scanner

### PWM Setup

Access the config.txt:

    adb shell mkdir -p /mnt/boot
    adb shell mount /dev/block/mmcblk0p1 /mnt/boot
    adb pull /mnt/boot/config.txt

Remove or comment the following line, if present: 
    
    dtoverlay=generic-i2s
    
Add the following line:

    dtoverlay=pwm-2chan-with-clk,pin=18,func=2,pin2=13,func2=4
    
Copy the modified file back:

    adb push config.txt /mnt/boot/config.txt
    adb shell sync
    adb reboot
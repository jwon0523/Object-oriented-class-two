package tv;

public class TV {
	final int MAX_CHANNEL = 5;
	final int MAX_VOLUME = 10;
	final int MIN_CHANNEL = 1;
	final int MIN_VOLUME = 0;
	
	boolean status = false;
	int channel = 1;
	int volume = 5;
	
	boolean getStatus() {
		return status;
	}
	
	int getChannel() {
		return channel;
	}
	
	int getVolume() {
		return volume;
	}
	
	
	void pushPower() {		
		this.status = true;
		if(this.status) {
			System.out.println("TV 전원이 ON입니다.");
		}
	}
	
	void channelUp() {
		if(!this.status) {
			System.out.println("TV 전원이 OFF입니다.");
			return;
		}
		if(channel < MAX_CHANNEL) {
			channel++;
		} else {
			channel = MIN_CHANNEL;
		}
	}
	
	void channelDown() {
		if(!this.status) {
			System.out.println("TV 전원이 OFF입니다.");
			return;
		}
		if(channel > MIN_CHANNEL) {
			channel--;
		} else {
			channel = MAX_CHANNEL;
		}
	}
	
	void volumeUp() {
		if(!this.status) {
			System.out.println("TV 전원이 OFF입니다.");
			return;
		}
		
		if(volume < MAX_VOLUME) {
			volume++;
		} else {
			System.out.println("최대 볼륨입니다.");
		}
	}
	
	void volumeDown() {
		if(!this.status) {
			System.out.println("TV 전원이 OFF입니다.");
			return;
		}
		
		if(volume > MIN_VOLUME) {
			volume--;
		} else {
			System.out.println("최소 볼륨입니다.");
		}
	}
}

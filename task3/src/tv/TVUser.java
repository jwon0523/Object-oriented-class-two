package tv;

public class TVUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV tv = new TV();
		System.out.println("현재 상태: " + tv.getStatus());
		System.out.println("현재 채널: " + tv.getChannel());
		System.out.println("현재 볼륨: " + tv.getVolume());
		
		System.out.println();
		
		tv.volumeUp();
		tv.channelDown();
		
		System.out.println();
		
		tv.pushPower();
		
		for(int i = 0; i < 6; i++) {
			tv.channelUp();
		}
		tv.volumeDown();
		System.out.println("현재 볼륨: " + tv.getVolume());
		for(int i = 0; i < 6; i++) {
			tv.volumeDown();
		}
		
		System.out.println();
		
		System.out.println("현재 채널: " + tv.getChannel());
		System.out.println("현재 볼륨: " + tv.getVolume());
	}

}

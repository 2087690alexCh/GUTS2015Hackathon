package Models;

public enum EventType{
	CHARITY(-10),
	SPEECH(-6),
	ATHLETICS(-3),
	RACE(-2),
	CONCERT(-1),
	RIVER(0),
	PICKET(1),
	MARCH(2),
	FOOTBALL(3),
	DEMONSTRATION(4),
	FRAUD(5),
	MUGGING(6),
	ROBBERY(7),
	MURDER(10);

	private int score;
	private EventType(int score){
		this.score=score;
	}
};


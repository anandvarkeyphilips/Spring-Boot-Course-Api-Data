package io.javabrains.springBootStarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic(1, "Spring Framework", "Spring Framework Description"),
					new Topic(2, "Hibernate Framework", "Hibernate Framework Description"),
					new Topic(3, "Javascript Framework", "Javascript Framework Description")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(int id) {
		return topics.stream().filter(t -> t.getId() == (id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(int id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic topicItem = topics.get(i);
			if (topicItem.getId() == id) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(int id) {
		topics.removeIf(t -> t.getId() == id);
	}
}